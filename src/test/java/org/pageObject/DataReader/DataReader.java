package org.pageObject.DataReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;


public class DataReader {

    public static ArrayList<HashMap<String, String>> getData(String jsonPath) throws IOException {
        //Convertir Json en String  usando la libreria Java.IO
        // El metodo recibe un archivo por eso se debe convertir la ruta en un archivo
        String jsonConver = FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);

        // Mapear un String para convertir en un arrayDeHashMap , esto se hace con la libreria jackson
        ObjectMapper objectMapper =  new ObjectMapper();
        ArrayList<HashMap<String,String>> data = objectMapper.readValue(jsonConver, new TypeReference<ArrayList<HashMap<String, String>>>() {});

        return data;
    }
}
