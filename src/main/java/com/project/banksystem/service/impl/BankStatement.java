package com.project.banksystem.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.banksystem.entity.Transaction;
import com.project.banksystem.entity.User;
import com.project.banksystem.repository.TransactionRepository;
import com.project.banksystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class BankStatement {

    private TransactionRepository transactionRepository;
    private UserRepository userRepository;
    private static final String FILE = "/home/morgan/Documents/MyBankStatement.pdf";
    /*
     *  retrieve list of transactions within a date range given an account number
     *  generate a PDF file of transactions
     * send the file via email
     */
    public List<Transaction> generateBankStatement(String accountNumber, String startDate, String endDate) throws DocumentException, IOException {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

        List<Transaction> transactionList = transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .filter(transaction -> transaction.getCreatedAt().isEqual(start))
                .filter(transaction -> transaction.getCreatedAt().isEqual(end)).toList();

        User user = userRepository.findByAccountNumber(accountNumber);
        String customerName = user.getFirstName() + " " + user.getLastName();

        Rectangle statementSize = new Rectangle(PageSize.A4);
        Document document = new Document(statementSize);
        log.info("setting size of the document");
        OutputStream outputStream = new FileOutputStream(FILE);
        PdfWriter.getInstance(document, outputStream);

        // Set up fonts and colors
        BaseFont baseFont = BaseFont.createFont();
        Font titleFont = new Font(baseFont, 14, Font.BOLD, BaseColor.BLACK);
        Font headerFont = new Font(baseFont, 12, Font.BOLD, BaseColor.WHITE);
        Font regularFont = new Font(baseFont, 10, Font.NORMAL, BaseColor.BLACK);

        // Open the document
        document.open();

        PdfPTable bankInfoTable = new PdfPTable(1);
        PdfPCell bankName = new PdfPCell(new Phrase("Native Spring Bank", titleFont));
        bankName.setBorder(0);
        bankName.setBackgroundColor(new BaseColor(51, 153, 102));
        bankName.setPadding(20f);

        PdfPCell bankAddress = new PdfPCell(new Phrase("41, Kantaoui, Hammam Sousse, Sousse 4089, Tunisia"));
        bankAddress.setBorder(0);
        bankInfoTable.addCell(bankName);
        bankInfoTable.addCell(bankAddress);

        PdfPTable statementInfo = new PdfPTable(2);
        PdfPCell customerInfo = new PdfPCell(new Phrase( "Start Date: " + startDate, headerFont));
        customerInfo.setBorder(0);
        PdfPCell statement = new PdfPCell(new Phrase("STATEMENT OF ACCOUNT", titleFont));
        statement.setBorder(0);
        PdfPCell stopDate = new PdfPCell(new Phrase("End Date" + endDate, headerFont));
        stopDate.setBorder(0);
        PdfPCell name = new PdfPCell(new Phrase("Customer Name: " + customerName, regularFont));
        name.setBorder(0);
        PdfPCell space = new PdfPCell();
        space.setBorder(0);
        PdfPCell address = new PdfPCell(new Phrase("Customer Address: " + user.getAddress(), regularFont));
        address.setBorder(0);

        PdfPTable transactionsTable = new PdfPTable(4);
        PdfPCell date = new PdfPCell(new Phrase("DATE", headerFont));
        date.setBackgroundColor(new BaseColor(51, 153, 102));
        date.setBorder(0);
        PdfPCell transactionType = new PdfPCell(new Phrase("TRANSACTION TYPE", headerFont));
        transactionType.setBackgroundColor(new BaseColor(51, 153, 102));
        transactionType.setBorder(0);
        PdfPCell transactionAmount = new PdfPCell(new Phrase("TRANSACTION AMOUNT", headerFont));
        transactionAmount.setBackgroundColor(new BaseColor(51, 153, 102));
        transactionAmount.setBorder(0);
        PdfPCell status = new PdfPCell(new Phrase("STATUS", headerFont));
        status.setBackgroundColor(new BaseColor(51, 153, 102));
        status.setBorder(0);

        transactionsTable.addCell(date);
        transactionsTable.addCell(transactionType);
        transactionsTable.addCell(transactionAmount);
        transactionsTable.addCell(status);

        transactionList.forEach(transaction -> {
            transactionsTable.addCell(new Phrase(transaction.getCreatedAt().toString(), regularFont));
            transactionsTable.addCell(new Phrase(transaction.getTransactionType(), regularFont));
            transactionsTable.addCell(new Phrase(transaction.getAmount().toString(), regularFont));
            transactionsTable.addCell(new Phrase(transaction.getStatus(), regularFont));
        });

        statementInfo.addCell(customerInfo);
        statementInfo.addCell(statement);
        statementInfo.addCell(endDate);
        statementInfo.addCell(name);
        statementInfo.addCell(space);
        statementInfo.addCell(address);

        document.add(bankInfoTable);
        document.add(statementInfo);
        document.add(transactionsTable);

        document.close();

        return transactionList;
    }

}
