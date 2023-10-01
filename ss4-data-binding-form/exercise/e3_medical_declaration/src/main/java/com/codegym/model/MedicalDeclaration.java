package com.codegym.model;

public class MedicalDeclaration {
    private int id;
    private String fullName;
    private int yearBirthday;
    private String gender;
    private String nationality;
    private String identification;
    private String vehicle;
    private String numberPlate;
    private String numberSeat;
    private int startDay;
    private int startMonth;
    private int startYear;
    private int endDay;
    private int endMonth;
    private int endYear;
    private String infoLast14Days;
    private String city;
    private String district;
    private String ward;
    private String address;
    private long phone;
    private String email;
    private boolean sot;
    private boolean ho;
    private boolean khoTho;
    private boolean dauHong;
    private boolean non;
    private boolean tieuchay;
    private boolean xuathuyet;
    private boolean noiban;

    private boolean dentrangtrai;
    private boolean tiepxucgan;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int id, String fullName, int yearBirthday, String gender, String nationality, String identification, String vehicle, String numberPlate, String numberSeat, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear, String infoLast14Days, String city, String district, String ward, String address, long phone, String email, boolean sot, boolean ho, boolean khoTho, boolean dauHong, boolean non, boolean tieuchay, boolean xuathuyet, boolean noiban, boolean dentrangtrai, boolean tiepxucgan) {
        this.id = id;
        this.fullName = fullName;
        this.yearBirthday = yearBirthday;
        this.gender = gender;
        this.nationality = nationality;
        this.identification = identification;
        this.vehicle = vehicle;
        this.numberPlate = numberPlate;
        this.numberSeat = numberSeat;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.infoLast14Days = infoLast14Days;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.dauHong = dauHong;
        this.non = non;
        this.tieuchay = tieuchay;
        this.xuathuyet = xuathuyet;
        this.noiban = noiban;
        this.dentrangtrai = dentrangtrai;
        this.tiepxucgan = tiepxucgan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearBirthday() {
        return yearBirthday;
    }

    public void setYearBirthday(int yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(String numberSeat) {
        this.numberSeat = numberSeat;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getInfoLast14Days() {
        return infoLast14Days;
    }

    public void setInfoLast14Days(String infoLast14Days) {
        this.infoLast14Days = infoLast14Days;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSot() {
        return sot;
    }

    public void setSot(boolean sot) {
        this.sot = sot;
    }

    public boolean isHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }

    public boolean isKhoTho() {
        return khoTho;
    }

    public void setKhoTho(boolean khoTho) {
        this.khoTho = khoTho;
    }

    public boolean isDauHong() {
        return dauHong;
    }

    public void setDauHong(boolean dauHong) {
        this.dauHong = dauHong;
    }

    public boolean isNon() {
        return non;
    }

    public void setNon(boolean non) {
        this.non = non;
    }

    public boolean isTieuchay() {
        return tieuchay;
    }

    public void setTieuchay(boolean tieuchay) {
        this.tieuchay = tieuchay;
    }

    public boolean isXuathuyet() {
        return xuathuyet;
    }

    public void setXuathuyet(boolean xuathuyet) {
        this.xuathuyet = xuathuyet;
    }

    public boolean isNoiban() {
        return noiban;
    }

    public void setNoiban(boolean noiban) {
        this.noiban = noiban;
    }

    public boolean isDentrangtrai() {
        return dentrangtrai;
    }

    public void setDentrangtrai(boolean dentrangtrai) {
        this.dentrangtrai = dentrangtrai;
    }

    public boolean isTiepxucgan() {
        return tiepxucgan;
    }

    public void setTiepxucgan(boolean tiepxucgan) {
        this.tiepxucgan = tiepxucgan;
    }
}