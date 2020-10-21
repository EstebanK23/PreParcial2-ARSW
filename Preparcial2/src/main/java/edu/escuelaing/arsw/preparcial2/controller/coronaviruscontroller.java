/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.preparcial2.controller;

import edu.escuelaing.arsw.preparcial2.services.coronavirusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author esteb
 */


@RestController
@RequestMapping(value = "/Coronavirus")
public class coronaviruscontroller {

    @Autowired
    @Qualifier("coronavirusServiceImpl")
    coronavirusServices cs;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllCases() {
        try {
           
            return new ResponseEntity<>(cs.getAllCases(),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
}
