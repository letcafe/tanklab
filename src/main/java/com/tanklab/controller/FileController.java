package com.tanklab.controller;

import com.tanklab.bean.File;
import com.tanklab.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/admin/file")
    public String getAllFiles(Model model) {
        model.addAttribute("fileList", fileService.selectFileList());
        return "admin/file";
    }

    @RequestMapping(value = "/uploadFileForm")
    public String uploadForm(Model model) {
        return "uploadFileForm";
    }

    @RequestMapping(value = "/file")
    public String getDetailedFile(
            Model model,
            @RequestParam(value = "id") int id) {
        model.addAttribute("detailedFile", fileService.selectDetailedFile(id));
        return "detailedFile";
    }




    @RequestMapping(value = "/fileList")
    public String getPagedFiles(Model model, @RequestParam(value = "page") int page) {
        int totalCount = fileService.getTableCount();
        int pageSize = 10;
        int maxPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        page = (page == 0) ? 1 : page;
        int startIndex = (page - 1) * pageSize;
        List<File> fileList = fileService.selectMany(startIndex, pageSize);

        model.addAttribute("pagedFile", fileList);
        page = (maxPage == 0) ? 0 : page;
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        if(page > 1) {
            model.addAttribute("prePageHref", "fileList?page=" + (page - 1));
        } else if(page < maxPage) {
            model.addAttribute("nextPageHref", "fileList?page" + (page + 1));
        }
        return "/web/fileList";
    }



}