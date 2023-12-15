package com.example.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Ruta donde se encuentran los archivos .feature
    glue = "stepsCucumber" // Paquete donde se encuentran las definiciones de pasos
)
public class BuscarProductoSteps {
	
}