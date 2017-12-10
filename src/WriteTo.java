public class WriteTo {
    public static void main(String[] args) throws Exception{
        String content = "add:\nx is 2\ny is 3\nz is x + y\nprint z";
        String filePath = "D:\\Documents\\HackKings\\WriteTo\\src\\Add.jvto";
        Write.createNew(filePath, content, 1, false, false);
    }
}
