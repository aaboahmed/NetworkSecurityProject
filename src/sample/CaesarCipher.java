package sample;

public class CaesarCipher extends Cipher {

    private int key ;
    private int letterCount = 26;

    public CaesarCipher() {
        this.key = 3;
    }
    public CaesarCipher(int key) {
        this.key = key;
    }

    @Override
    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : message.toCharArray()) {
            if (Character.isUpperCase(currentChar)) {
                char ch = (char) (((int) currentChar +
                        key - 'A') % letterCount + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar +
                        key - 'a') % letterCount + 'a');
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encryptedMessage) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : encryptedMessage.toCharArray()) {
            if (Character.isUpperCase(currentChar)) {
                char ch = (char) (((int) currentChar -
                        key - 'A' + letterCount) % letterCount + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar -
                        key - 'a' + letterCount) % letterCount + 'a');
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

}