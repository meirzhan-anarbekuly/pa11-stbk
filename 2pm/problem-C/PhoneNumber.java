class PhoneNumber {
    private PhoneNumberType type;
    private String number;
    
    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }
    
    public PhoneNumberType getType() {
        return type;
    }
    
    public String getNumber() {
        return number;
    }
}