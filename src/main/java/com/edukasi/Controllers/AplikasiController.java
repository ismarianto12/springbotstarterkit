package com.edukasi.Controllers;

import com.edukasi.Config.ConfigApp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1")
@RestController
public class AplikasiController {

    public String ConfiggetApidev;

    AplikasiController(ConfigApp configApp) {
        this.ConfiggetApidev = configApp.getApidev();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResponseEntity<?> index() {
        Map<String, Object> model = new HashMap();
        try {
            model.put("message", System.getProperty("java.version"));
            model.put("title", "Hello World");
            return ResponseEntity.ok().body(model);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("message", System.getProperty("java.version"));
            model.put("title", "Hello World");
            return ResponseEntity.badRequest().body(model);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> users() throws Exception {
        Map<String, Object> model = new HashMap();
        try {
            URL url = new URL(this.ConfiggetApidev);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setConnectTimeout(5400);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseContent = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine).append("\n");
            }
            in.close();
            con.disconnect();
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> resultList = mapper.readValue(responseContent.toString(), new TypeReference<List<Map<String, Object>>>() {
            });
            model.put("response", resultList);
            return ResponseEntity.badRequest().body(model);

        } catch (Exception e) {
            e.printStackTrace();
            model.put("response", e.getMessage());
            return ResponseEntity.badRequest().body(model);
        }
    }

}
