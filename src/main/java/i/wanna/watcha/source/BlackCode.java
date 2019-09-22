package i.wanna.watcha.source;

public enum BlackCode implements CodeInter {

    TOOMUCH("과도한 상담요구","TOOMUCH"),
    GIVENUMBER("연락처 요구","GIVENUMBER"),
    ERO("음란성 사진 게시","ERO"),
    TALK("언어폭력/성희롱","TALK"),
    OTHER("기타", "OTHER"),
    ADMIN("관리자에서등록", "ADMIN");

    private String title;
    private String value;

    BlackCode(String title, String value){
        this.title = title;
        this.value = value;
    }

    @Override
    public String getCode(){
        return name();
    }

    @Override
    public String getTitle(){
        return this.title;
    }

    @Override
    public String getValue(){
        return this.value;
    }

}