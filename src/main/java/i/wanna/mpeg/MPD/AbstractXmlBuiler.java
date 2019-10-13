package i.wanna.mpeg.MPD;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.xembly.Directives;

@Getter
@Setter
public abstract class AbstractXmlBuiler implements RTSPXmlCreater{
    private String ori_file_path; //사실 들고있을 필요없는딩 헿
    private Directives directives = new Directives();

    abstract void directivesBuilder();

    protected abstract void createHeader();
    protected abstract void createBaseURL();
    protected abstract void createPeriod();
    protected abstract void createAdaptaionSet();


}
