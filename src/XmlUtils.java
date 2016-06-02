import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.InputStreamResource;

/**
 * Created by Gil Peretz on 24/04/2016.
 */
public class XmlUtils {
    public static <T> T buildBeanObject(String xmlBean, Class<T> clazz) {
        final GenericApplicationContext ctx = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
        xmlReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_XSD);
        xmlReader.loadBeanDefinitions(new InputStreamResource(new ByteArrayInputStream(xmlBean.getBytes(StandardCharsets.UTF_8))));
        ctx.refresh();
        final T result = ctx.getBean(clazz);
        ctx.close();
        return result;
    }
}
