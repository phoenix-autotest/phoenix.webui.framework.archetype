package ${package}.remote;

import ${package}.github.page.GithubPage;
import org.dom4j.DocumentException;
import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.settings.Phoenix;
import org.xml.sax.SAXException;

import java.io.IOException;

@AutoApplication(name = "Phoenix平台自动化测试",
        scanBasePackages = "${package}.github.page"
)
public class RemoteTest {
    public static void main(String[] args) throws DocumentException, SAXException, IOException {
        Phoenix phoenix = new Phoenix(RemoteTest.class);
        phoenix.init();
        phoenix.readFromClassPath("autotest.xml");

        GithubPage page = phoenix.getPage(GithubPage.class);
        page.open();

        phoenix.shutdown();
    }
}
