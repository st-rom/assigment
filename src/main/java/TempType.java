public enum TempType {
    KELVIN, CELSIUM;

    public double toDouble() {
        switch (this) {
            case KELVIN:
                return 0;
            case CELSIUM:
                return 273.15;
            default:
                return 0;
        }
    }
}
