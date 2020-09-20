package base;

public class TestInvertedCode {

    public void testInvertedCode() {
        String string = Integer.toBinaryString(-1);
        //反码+1求源码
        StringBuilder builder = new StringBuilder();
        builder.append(1);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                builder.append(0);
            } else {
                builder.append(1);
            }
        }
        char last = builder.charAt(builder.length() - 1);
        last += 1;
        builder.setCharAt(builder.length() - 1, last);
        for (int i = builder.length() - 1; i > 0; i--) {
            char current = builder.charAt(i);
            if (current == '2') {
                last = builder.charAt(i - 1);
                last += 1;
                builder.setCharAt(i, '0');
                builder.setCharAt(i - 1, last);
            } else {
                break;
            }
        }

        builder.setCharAt(0, '0');

        System.out.println(builder.toString());

        System.out.println(Integer.toBinaryString(-1));
    }
}
