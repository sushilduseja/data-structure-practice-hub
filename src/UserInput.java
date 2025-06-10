public class UserInput {
    
    public static class TextInput {
        //- adds the given character to the current value
        StringBuilder sb = new StringBuilder();
        public void add(char c) {
            sb.append(c);
        }

         //- returns the current value
        public String getValue() {
            return sb.toString();
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char c) {
            if(Character.isDigit(c)) {
                sb.append(c);
            }
        }
    }

    public static void main(String[] args) {
        //TextInput input = new TextInput();
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());


    }
}