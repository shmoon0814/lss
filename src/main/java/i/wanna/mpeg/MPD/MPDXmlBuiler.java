package i.wanna.mpeg.MPD;

import lombok.Getter;
import lombok.Setter;
import org.xembly.Directives;
import org.xembly.ImpossibleModificationException;
import org.xembly.Xembler;

import java.io.File;

@Getter
@Setter
public class MPDXmlBuiler extends AbstractXmlBuiler {

    private MPDXmlBuiler(){}
    private MPDXmlBuiler(String ori_file_path){
        super.setOri_file_path(ori_file_path);
    }

    public static AbstractXmlBuiler builder(String ori_file_path){
        return new MPDXmlBuiler(ori_file_path);
    }

    //TODO Reactive Programming 변경
    @Override
    protected void directivesBuilder(){
        createHeader();
        createBaseURL();
        createPeriod();
        createAdaptaionSet();
        try {
            String xml = new Xembler(
                    super.getDirectives()
            ).xml();
            System.out.println(xml);
        }catch (ImpossibleModificationException e){
            e.printStackTrace();
        }
    }

//    String xml = new Xembler(
//            new Directives()
//                    .add("root")
//                    .add("order")
//                    .attr("id", "553")
//                    .set("$140.00")
//    ).xml();
    @Override
    protected void createHeader(){
        super.getDirectives()
                .add("MPD")
                .attr("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
                .attr("xmlns","urn:mpeg:DASH:schema:MPD:2011")
                .attr("xsi:schemaLocation","urn:mpeg:DASH:schema:MPD:2011")
                .attr("profiles","urn:mpeg:dash:profile:isoff-main:2011")
                .attr("type","static")
                .attr("mediaPresentationDuration","PT0H9M56.46S")
                .attr("minBufferTime","PT20.0S")
        ;
    }

    @Override
    protected void createBaseURL(){
        super.getDirectives().add("BaseURL").set("http://localhost:8080/filePath").up();
    }

    @Override
    protected void createPeriod(){
        super.getDirectives().add("Period").attr("start", "PT0S");
    }

    @Override
    protected void createAdaptaionSet(){
        super.getDirectives().add("AdaptationSet").attr("bitstreamSwitching","true");
    }

    @Override
    public String makeXmlString(String ori_file_path){
        try{
            System.out.println("Original File Path == " + super.getOri_file_path());
            File file = new File(super.getOri_file_path());
            if(!file.exists()){
                System.err.println("File not exist. file Path == " + super.getOri_file_path());
            }
            this.directivesBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "check it!";
    }



}
