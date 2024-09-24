package com.junitpushup;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    private Example example;
    //private MayorCero mayorCero;

    int resultInt;
    boolean resultBoolean;
    int numberA ;
    int numberB ;
    String cadena;

    // antes de cada prueba se ejecute el siguiente codigo
    @BeforeEach
    public void init() {
        this.example = new Example();
        //this.mayorCero = new MayorCero();
    }

    


    @Test
    public void testSumar(){
        //Given - elementos que se tienen para realizar la prueba
        numberA = 5;
        numberB = 10;

        //When : Cuando
        resultInt = example.sumar(numberA, numberB);
        //Then - Entonces

        // verificar si el resultado no sea nulo 
        assertNotNull(resultInt);

        // primer valor es el esperador y el segundo el resultado
        assertEquals(15, resultInt);

        // esto nos permite verificar si un resultado recibido o verifica pertenece a una clase especifica
        // primer valor es el tipo de dato y el segundo es el resultado
        // verificar si el result es de tipo entero
        assertInstanceOf(Integer.class, resultInt);
    }   


    @Test
    public void testCheckPositivo() {
        int numberA = 5;
        boolean resultBoolean = example.checkPositivo(numberA);

        // Verificar que el retorno es true para número positivo
        assertTrue(resultBoolean, "El valor retornado debería ser true para un número positivo");

        // Verificar que numberA es mayor a cero
        assertTrue(numberA > 0, "El número debería ser mayor a cero");

        // Verificar que numberA es un Integer
        assertInstanceOf(Integer.class, numberA);
    }

    @Test
    public void testCheckPositivoNumeroNegativo() {
        int numberA = -5;

        // Verificar que se lanza IllegalArgumentException para un número negativo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            example.checkPositivo(numberA);
        });

        // Verificar que el mensaje de excepción es correcto
        String expectedMessage = "El número no puede ser negativo";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage, "El mensaje de excepción no coincide");
    }


    @Test 
    public void testcontarLetrasA () {
        cadena = "Cadena";
        resultInt = example.contarLetrasA(cadena);
        assertInstanceOf(Integer.class , resultInt);
    }

    @Test 
    public void testcontieneElemento () {
        List<String> lista = new ArrayList<>();
        lista.add("Danielo"); 
        lista.add("Samuel");
        cadena = "Daniel";
        resultBoolean = example.contieneElemento(lista, cadena); 
        assertInstanceOf(Boolean.class, resultBoolean);
    }

    @Test 
    public void testRevertirCadena () {

        cadena = "Revertir";
        assertInstanceOf(String.class , example.revertirCadena(cadena));
       
    }

    @Test
    public void testRevertirCadenaNegativo() {
        cadena = "";
         cadena =  new StringBuilder(cadena).reverse().toString();
        // Verificar que se lanza IllegalArgumentException para un número negativo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            example.revertirCadena(cadena);
        });

        // Verificar que el mensaje de excepción es correcto
        String expectedMessage = "La cadena esta vacia";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage, "El mensaje de excepción no coincide");
    }


    @Test 
    public void testFactorial () {
        numberA = 5;
        assertInstanceOf(Long.class , example.factorial(numberA));
       
    }

    @Test
    public void testFactorialNegativo() {
        numberA = -1;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            example.factorial(numberA);
        });

        // Verificar que el mensaje de excepción es correcto
        String expectedMessage = "Factorial no definido para números negativos";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage, "El mensaje de excepción no coincide");
    }


    @Test 
    public void testEsPrimo () {
        numberA = 5;
        assertInstanceOf(Boolean.class , example.esPrimo(numberA));

        numberA = 1;
        assertInstanceOf(Boolean.class , example.esPrimo(numberA));
        
        numberA = 4;
        assertInstanceOf(Boolean.class , example.esPrimo(numberA));
    }

    @Test 
    public void testConvertirAString () {
        List<Integer> listaInt = new ArrayList<>(); 
        listaInt.add(1);
        listaInt.add(5); 

        assertNotNull(example.convertirAString(listaInt));
        assertInstanceOf(List.class, example.convertirAString(listaInt));

        
    }

    @Test 
    public void testCalcularMedia () {
        List<Integer> listaInt = new ArrayList<>(); 
        listaInt.add(1);
        listaInt.add(5); 
        listaInt.add(9); 

        assertNotNull(example.calcularMedia(listaInt));
        assertInstanceOf(Double.class, example.calcularMedia(listaInt));
    }


    @Test
    public void testcalcularMediaVacia() {
        List<Integer> listaInt = new ArrayList<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            example.calcularMedia(listaInt);
        });

        // Verificar que el mensaje de excepción es correcto
        String expectedMessage = "La lista no puede ser nula o vacía";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage, "El mensaje de excepción no coincide");
    }


    @Test
    public void testcalcularMediaNull() {
        List<Integer> listaInt = null;


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            example.calcularMedia(listaInt);
        });

        // Verificar que el mensaje de excepción es correcto
        String expectedMessage = "La lista no puede ser nula o vacía";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage, "El mensaje de excepción no coincide");
    }


    @Test 
    public void testConvertirListaAString () {
        List<String> listaString = new ArrayList<>(); 
        listaString.add("David");
        listaString.add("Samuel"); 
        listaString.add("haahah"); 

        assertNotNull(example.convertirListaAString(listaString));
        assertInstanceOf(String.class, example.convertirListaAString(listaString));

        System.out.println(example.convertirListaAString(listaString));
    }
}
