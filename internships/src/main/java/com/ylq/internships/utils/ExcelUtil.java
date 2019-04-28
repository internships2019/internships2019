package com.ylq.internships.utils;

import com.ylq.internships.entity.Class;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

     static public List<Class>  getClassListByExcel(MultipartFile file) throws IOException {
        boolean isExcel2003 = true;
        List<Class> list=new ArrayList<>();
        if (file.getOriginalFilename().matches("^.+\\.(?i)(xlsx)$")){
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb=null;
        if (isExcel2003){
            wb=new HSSFWorkbook(is);
        }else {
            wb=new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet!=null&&sheet.getRow(0).getPhysicalNumberOfCells()==6&&sheet.getRow(0).getCell(0)!=null){//当工作簿的列数为5且第一列有内容时则视为格式正确
            for (int r=1;r<=sheet.getLastRowNum();r++){//当前行
                Boolean flag=true;
                Row row = sheet.getRow(r);
                if (row==null){
                    continue;
                }
                for (int i=0;i<6;i++){//当前单元格
                    if (row.getCell(i)==null){
                        flag=false;
                        break;
                    }
                    row.getCell(i).setCellType(CellType.STRING);
                }
                if (flag){
                    Class aClass=new Class();
                    aClass.setClassName(row.getCell(0).getStringCellValue());
                    aClass.setCollegeName(row.getCell(1).getStringCellValue());
                    aClass.setDisplineName(row.getCell(2).getStringCellValue());
                    aClass.setClassStuNum(row.getCell(3).getStringCellValue());
                    aClass.setInstructorName(row.getCell(4).getStringCellValue());
                    aClass.setInstructorTel(row.getCell(5).getStringCellValue());
                    list.add(aClass);
                }
            }
            return list;
        }
        return null;
    }
}
