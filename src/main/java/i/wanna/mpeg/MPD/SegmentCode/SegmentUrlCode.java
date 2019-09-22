package i.wanna.mpeg.MPD.SegmentCode;

import lombok.Getter;

import java.util.function.Function;

@Getter
public enum SegmentUrlCode {

    //음.. 이넘의 앞에는 값을 좀 생각 해 봐야겠다
    //이거 이런식으로 짜면 안될꺼 같은대
    //TODO 제약사항이랑 값을 빌드하는 것을 꺼내서 구현해야 한다.. 이거 좀 어렵내
   M("M", "MPD@id", null),
   I("I", "Period@id", null),
   A("A", "AdaptaionSet@id", null),
   g("g", "AdaptaionSet@lang", null),
   l("L", "AdaptaionSet@par", null),
   P("P", "AdaptaionSet@id", null),
   R("R", "Representaion@id", null),
   B("B", "Representaion@bandwidth", null),
   W("W", "Common@width", null),
   H("H", "Common@height", null),
   s("s", "Common@sar", null),
   F_frateRate("F", "Common@framerate", null),
   F_audioSamplingRate("F", "Comoon@audioSamplingRate", null),
   N("N", "$Number$", null),
   T("T", "$Time$", null),
   C("C", "Common@codecs", null);


    private String filed_prefix;
    private String correspoding_MPD_variable;
    private SegmentRestrictions restrictions;

    SegmentUrlCode(String filed_prefix, String correspoding_MPD_variable, SegmentRestrictions restrictions){
        this.filed_prefix = filed_prefix;
        this.correspoding_MPD_variable = correspoding_MPD_variable;
        this.restrictions = restrictions;
    }

    public String getFiled_prefix(){
        return this.filed_prefix;
    }

    public String getCorrespoding_MPD_variable(){
        return this.correspoding_MPD_variable;
    }

    public SegmentRestrictions getRestrictions(){
        return this.restrictions;
    }

}
