package i.wanna.mpeg.MPD;

import i.wanna.mpeg.model.FfmpegData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.xembly.Directives;

@Getter
@Setter
public abstract class AbstractXmlBuiler implements RTSPXmlCreater{
    private FfmpegData ffmpegData;
    private Directives directives = new Directives();

    abstract void directivesBuilder();

    protected abstract void createHeader();
    protected abstract void createBaseURL();
    protected abstract void createPeriod();
    protected abstract void createAdaptaionSet();

    protected String changeDuration(){
        this.ffmpegData.getMediaPresentationDuration();
        return "//TODO!!";
    }

}
