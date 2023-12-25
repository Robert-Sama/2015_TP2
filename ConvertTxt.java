public class ConvertTxt {
    public String replacePunctuation(String txt){
        txt = txt.replaceAll("\\p{Punct}", " ");
        return txt;
    }

    public String replaceSpace(String txt){
        txt = txt.replaceAll("\\s{2,}", " ").trim();
        return txt;
    }
}
