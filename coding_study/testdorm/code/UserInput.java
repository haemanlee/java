package testdorm.code;


public class UserInput {

    public static class TextInput {
        private String input = "";
        void add(char c) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            input += sb.toString();
        };
        String getValue() {
            return this.input;
        };
    }

    public static class NumericInput extends TextInput{
        private String input = "";
        @Override
        void add(char c){
            if(String.valueOf(c).matches("^[0-9]+$")){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                input += sb.toString();
            }
        }
        @Override
        String getValue() {
            return this.input;
        }

    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
