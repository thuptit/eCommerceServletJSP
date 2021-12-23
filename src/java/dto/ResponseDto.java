/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author thunv
 */
public class ResponseDto <T>{
    public boolean success;
    public String message;
    public List<T> data;

    public ResponseDto(boolean success, String message, List<T> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    
}
