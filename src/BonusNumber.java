public class BonusNumber {

    private final int number;

    public BonusNumber(String inputBonusNumber) {
        this.number = validate(inputBonusNumber); //여기서 벨리데이트로 보내고 디스로 초기화가 더 좋음
    }

    private int validate(String inputBonusNumber) {
        int bonusNumber = validateBonusNumberType(inputBonusNumber);
        validateNumberSize(bonusNumber);
        return bonusNumber;
    }

    private int validateBonusNumberType(String inputBonusNumber) { //벨리데이트가 2가지를 검증하는중, 분리필요
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validateNumberSize(int number) {
        if (number > LottoNumberFactory.MAX_LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 큽니다");
        }
        if (number < LottoNumberFactory.MIN_LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 작습니다");
        }
    }

    public int getNumber() {
        return number;
    }
}
