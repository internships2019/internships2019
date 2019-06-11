package com.ylq.internships.utils;

import com.ylq.internships.entity.Class;
import com.ylq.internships.entity.WaitInsertInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    //读取班级excel表
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
        if (sheet!=null&&sheet.getRow(0).getPhysicalNumberOfCells()==6&&sheet.getRow(0).getCell(0)!=null){//当工作簿的列数为6且第一列有内容时则视为格式正确
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

    //读取学生excel表
    static public List<WaitInsertInfo> getStudentListByExcel(MultipartFile file,List<String> classs) throws IOException {
        boolean isExcel2003 = true;
        ArrayList<WaitInsertInfo> list = new ArrayList<>();
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
        if (sheet!=null&&sheet.getRow(0).getPhysicalNumberOfCells()==6&&sheet.getRow(0).getCell(0)!=null) {//当工作簿的列数为6且第一列有内容时则视为格式正确
            for (int r=1;r<=sheet.getLastRowNum();r++){//当前行
                Boolean flag=true;
                Row row = sheet.getRow(r);
                for (int i=0;i<6;i++){//当前单元格
                    if (row.getCell(i)==null){
                        flag=false;
                        break;
                    }
                    row.getCell(i).setCellType(CellType.STRING);
                    if (row.getCell(i).getStringCellValue()==""){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    if (classs.contains(row.getCell(5).getStringCellValue())){//判断班级名是否存在
                        WaitInsertInfo waitInsertInfo = new WaitInsertInfo();
                        waitInsertInfo.setpNo(row.getCell(0).getStringCellValue());
                        waitInsertInfo.setpName(row.getCell(1).getStringCellValue());
                        waitInsertInfo.setpSex(row.getCell(2).getStringCellValue());
                        waitInsertInfo.setpTel(row.getCell(3).getStringCellValue());
                        waitInsertInfo.setpId(row.getCell(4).getStringCellValue());
                        waitInsertInfo.setClassName(row.getCell(5).getStringCellValue());
                        list.add(waitInsertInfo);
                    }
                }
            }
            return list;
        }
        return null;
    }

    //读取教师excel表
    static public List<WaitInsertInfo> getTeacherListByExcel(MultipartFile file) throws IOException {
        boolean isExcel2003 = true;
        ArrayList<WaitInsertInfo> list = new ArrayList<>();
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
        if (sheet!=null&&sheet.getRow(0).getPhysicalNumberOfCells()==5&&sheet.getRow(0).getCell(0)!=null) {//当工作簿的列数为5且第一列有内容时则视为格式正确
            for (int r=1;r<=sheet.getLastRowNum();r++){//当前行
                Boolean flag=true;
                Row row = sheet.getRow(r);
                for (int i=0;i<5;i++){//当前单元格
                    if (row.getCell(i)==null){
                        flag=false;
                        break;
                    }
                    row.getCell(i).setCellType(CellType.STRING);
                    if (row.getCell(i).getStringCellValue()==""){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    WaitInsertInfo waitInsertInfo = new WaitInsertInfo();
                    waitInsertInfo.setpNo(row.getCell(0).getStringCellValue());
                    waitInsertInfo.setpName(row.getCell(1).getStringCellValue());
                    waitInsertInfo.setpSex(row.getCell(2).getStringCellValue());
                    waitInsertInfo.setpId(row.getCell(3).getStringCellValue());
                    waitInsertInfo.setpTel(row.getCell(4).getStringCellValue());
                    list.add(waitInsertInfo);
                }
            }
            return list;
        }
        return null;
    }
}
