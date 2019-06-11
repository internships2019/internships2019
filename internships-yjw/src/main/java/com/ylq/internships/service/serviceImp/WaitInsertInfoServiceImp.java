package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.mapper.ClassMapper;
import com.ylq.internships.mapper.WaitInsertInfoMapper;
import com.ylq.internships.service.ClassService;
import com.ylq.internships.service.WaitInsertInfoService;
import com.ylq.internships.utils.Contant;
import com.ylq.internships.utils.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class WaitInsertInfoServiceImp implements WaitInsertInfoService {

    @Autowired
    private WaitInsertInfoMapper waitInsertInfoMapper;
    @Autowired
    private ClassMapper classMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    //获取已录人员信息列表
    @Override
    public PageInfo<WaitInsertInfo> findStudentAll(int page,int limit,String unitName, String pStatus) {
        logger.info("WaitInsertInfoServiceImp的findStudentAll执行了");
        PageHelper.startPage(page,limit);
        List<WaitInsertInfo> list = waitInsertInfoMapper.getStudentAll(unitName, pStatus);
        PageInfo<WaitInsertInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //通过编号获取录入人员信息
    public WaitInsertInfo findWaitInsertInfoByPno(String unitName,String pNo){
        logger.info("WaitInsertInfoServiceImp的findWaitInsertInfoByPno执行了");
        return waitInsertInfoMapper.getWaitInsertInfoByPNo(pNo,unitName);
    }

    //获取WaitInsertInfo详细信息
    @Override
    public WaitInsertInfo findWaitInsertInfoById(int id) {
        return waitInsertInfoMapper.getWaitInsertInfoById(id);
    }

    //通过人员姓名获取人员信息
    @Override
    public PageInfo<WaitInsertInfo> findWaitInsertInfoByName(int page, int limit, String unitName, String pStatus, String pName) {
        logger.info("WaitInsertInfoServiceImp的findStudentByName执行了"+pStatus+"==="+pName+"==="+unitName);
        PageHelper.startPage(page,limit);
        List<WaitInsertInfo> list = waitInsertInfoMapper.getWaitInsertInfoByName(unitName, pStatus, pName);
        PageInfo<WaitInsertInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //获取人员照片路径
    @Override
    public WaitInsertInfo findTeacherById(int id) {
        logger.info("WaitInsertInfoServiceImp的findStudentByName执行了"+id);
        return waitInsertInfoMapper.getTeacherById(id);
    }

    //添加待录人员信息
    @Transactional
    @Override
    public String addWaitInsertInfo(WaitInsertInfo waitInsertInfo) {
        logger.info("WaitInsertInfoServiceImp的addWaitInsertInfo执行了");
        if (findWaitInsertInfoByPno(waitInsertInfo.getUnitName(),waitInsertInfo.getpNo())==null){
            waitInsertInfoMapper.insert(waitInsertInfo);
            return "1";
        }
        return "2";
    }

    //更换照片
    @Transactional
    @Override
    public void editImg(String id, String path) {
        waitInsertInfoMapper.updateImg(id,path);
    }

    //修改教师信息
    @Transactional
    @Override
    public void editTeacher(WaitInsertInfo waitInsertInfo) {
        logger.info("WaitInsertInfoServiceImp的editTeacher执行了");
        waitInsertInfoMapper.updateTeacher(waitInsertInfo);
    }

    //修改学生信息
    @Transactional
    @Override
    public void editStudent(WaitInsertInfo waitInsertInfo) {
        logger.info("WaitInsertInfoServiceImp的editStudent执行了");
        waitInsertInfoMapper.updateStudent(waitInsertInfo);
    }

    //批插入待录人员信息
    @Transactional
    @Override
    public String batchAddWaitInsertInfo(MultipartFile file, String schoolName, String pStatus) throws IOException {
        logger.info("WaitInsertInfoServiceImp的batchAddWaitInsertInfo执行了==="+schoolName+"==="+pStatus);
        if (pStatus.equals(Contant.STUDENT)) {//学生待录
            List<String> classs = classMapper.getNames(schoolName);//获取学校班级列表
            List<WaitInsertInfo> list = ExcelUtil.getStudentListByExcel(file,classs);
            if (list == null) {//list为null表明excel1格式有误
                return null;
            }
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setUnitName(schoolName);
                list.get(i).setpStatus(Contant.STUDENT);
                System.out.println(list.get(i).toString());
            }
            waitInsertInfoMapper.batchInsert(list);
            return "1";
        }else {
            List<WaitInsertInfo> list = ExcelUtil.getTeacherListByExcel(file);
            if (list==null)
                return null;
            if (Contant.TEACHER_COMPANY.equals(pStatus)){//企业指导老师
                for (int i=0;i<list.size();i++){
                    list.get(i).setpStatus(Contant.TEACHER_COMPANY);
                    list.get(i).setUnitName(schoolName);
                    System.out.println(list.get(i).toString());
                }
            }else {//学校带队老师
                for (int i=0;i<list.size();i++){
                    list.get(i).setpStatus(Contant.TEACHER_SCHOOL);
                    list.get(i).setUnitName(schoolName);
                    System.out.println(list.get(i).toString());
                }
            }
            waitInsertInfoMapper.batchInsertTeacher(list);
            return "1";
        }
    }


    //批删除人员信息
    @Transactional
    @Override
    public void batchDeleteWaitInsertInfo(String[] arr) {
        logger.info("WaitInsertInfoServiceImp的batchDeleteWaitInsertInfo执行了");
        waitInsertInfoMapper.batchDelete(arr);
    }

    //删除人员信息
    @Override
    public void removeWaitInsertInfo(int id) {
        logger.info("WaitInsertInfoServiceImp的removeWaitInsertInfo执行了");
        waitInsertInfoMapper.deleteWaitInsertInfo(id);
    }
}
