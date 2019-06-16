/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.util;

/**
 *
 * @author Admin
 */
public class Pager {
    
    public static String HyperLink(String url, String page){
        return "<a class=\"paging\" href=\""+url+"\" >" + page +"</a>";
    }
    
    public static String Label (String page){
        return "<span class=\"paging\" >"+page+"</span>";
    }
    
    public static String Pager(int gap, int pageIndex, int totalSize){
        String result = "";
        if (pageIndex - gap > 1){
            result += HyperLink("?page=1", "First");
        }
        
        for (int i = gap; i > 0; i--) {
            int page = pageIndex - i;
            if (page > 0){
                result += HyperLink("?page="+page, page+"");
            }
        }
        
        result += Label(pageIndex+"");
        
        for (int i = 1; i < gap; i++) {
            int page = pageIndex + i;
            if (page <= totalSize){
                result += HyperLink("?page="+page, page+"");
            }
        }
        
        if (pageIndex + gap < totalSize){
            result += HyperLink("?page="+totalSize,"Last");
        }
        
        
        
        return result;
    }
}
