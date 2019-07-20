package org.casadocodigo.store.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        try {
            ServletContext servletContext = request.getServletContext();
            String realPath = servletContext.getRealPath(String.format("/%s", baseFolder));
            String originalFilename = file.getOriginalFilename();

            file.transferTo(new File(String.format("%s/%s", realPath, originalFilename)));

            return String.format("%s/%s", baseFolder, originalFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
