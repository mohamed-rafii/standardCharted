package com.scp.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DigitalScannerTest {

    DigitalScanner digitalScanner = new DigitalScanner();
    ClassLoader classLoader = DigitalScannerTest.class.getClassLoader();
    String multipleChunksWithIllegalRow = null;
    String multiChunks = null;
    String multiLinesChunks = null;
    String singleChunks = null;

    @Before
    public void init() throws IOException {
        digitalScanner = new DigitalScanner();
        digitalScanner.populateData();
        File fileMultipleChunks = new File(classLoader.getResource("multipleChunks.txt").getFile());
        multiChunks = new String(Files.readAllBytes(Paths.get(fileMultipleChunks.getPath())));

        File fileMultipleLinesChunks = new File(classLoader.getResource("multipleLines.txt").getFile());
        multiLinesChunks = new String(Files.readAllBytes(Paths.get(fileMultipleLinesChunks.getPath())));

        File fileMultipleChunksWithIllegalRow = new File(classLoader.getResource("multipleChunksWithIllegalRow.txt").getFile());
        multipleChunksWithIllegalRow = new String(Files.readAllBytes(Paths.get(fileMultipleChunksWithIllegalRow.getPath())));

        File fileSingleChunk = new File(classLoader.getResource("singleChunk.txt").getFile());
        singleChunks = new String(Files.readAllBytes(Paths.get(fileSingleChunk.getPath())));

    }

    @Test
    public void getNumber() {
        Assert.assertEquals("123456789123456789123456789",  digitalScanner.getNumber(multiChunks));
        Assert.assertEquals("123456789123456ILL89123456789",  digitalScanner.getNumber(multipleChunksWithIllegalRow));
        Assert.assertEquals("000000000",  digitalScanner.getNumber(singleChunks));
        Assert.assertEquals("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789",  digitalScanner.getNumber(multiLinesChunks));
    }
}