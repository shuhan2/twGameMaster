package com.tw;


import com.tw.practice.Game;
import com.tw.practice.NumberGenerator;
import com.tw.practice.NumberReader;
import com.tw.practice.Printer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private NumberGenerator mockedGenerator;

    @Mock
    private Printer mockedPrinter;

    @Mock
    private NumberReader mockedReader;

    @Test
    public void shouldReturn4A0BWhenInputSameNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("1234");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("you win");
    }

    @Test
    public void shouldReturn0A0BWhenInputDifferentNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("5678");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A0B");
    }

    @Test
    public void shouldReturn0A4BWhenInputSameDigitNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("4321");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A4B");
    }

    @Test
    public void shouldReturnXA0BWhenInputRandomNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("1256");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("2A0B");
    }

    @Test
    public void shouldReturn0AXBWhenInputRandomNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("2789");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A1B");
    }
}