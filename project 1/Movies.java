class Movies{
    private String name;
    private String level;
    private String hint;
    public Movies(String name, String level, String hint) {
        this.Name = name;
        this.level = level;
        this.hint = hint;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public void setLevel(final String level) {
        this.level = level;
    }
    public void setHint(final String hint) {
        this.hint = hint;
    }
    public String getName() {
        return this.name;
    }
    public String getLevel() {
        return this.level;
    }
    public String getHint() {
        return this.hint;
    }

}