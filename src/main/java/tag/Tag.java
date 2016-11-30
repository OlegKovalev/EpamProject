package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Tag extends TagSupport {
    private String language;
    private LocalDateTime localDateTime;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public int doStartTag() throws JspException {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, 
                FormatStyle.MEDIUM).withLocale(new Locale(language));
        try {
            pageContext.getOut().write(localDateTime.format(formatter));
        } catch (IOException cause) {
            throw new JspException(cause);
        }
        return SKIP_BODY;
    }
}