import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(
    fileSizeThreshold = 1024*1024*2, /*2MB*/
    maxFileSize = 1024*1024*10, /*10MB*/
    maxRequestSize=1024*1024*50 /*50MB*/
)
public class LogUploadServlet extends HttpServlet {
    private static final String SAVE_DIR = "uploadFiles";
    private String savePath;
    @Override
    public void init() throws ServletException {
        savePath = "/Users/kirk/Developer/utils/filebeat";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        File fileSaveDirectory = new File(savePath);
        if (!fileSaveDirectory.exists()) {
            fileSaveDirectory.mkdir();
        }
        String fileName = "";
        System.err.println(req.getParts().size());
        for (Part part: req.getParts()) {
            // this method is for Servlet 3.1, tomcat 8
            fileName = part.getSubmittedFileName();
            System.err.println(fileName);
            part.write(savePath + File.separator + fileName);
        }
        PrintWriter out = res.getWriter();
        out.println(fileName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
        PrintWriter out = res.getWriter();
        out.println("GET DONE");
    }
}
