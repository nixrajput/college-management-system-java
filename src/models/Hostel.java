package models;

/**
 *
 * @author nixrajput
 */
public class Hostel {

    private final String _reg_no;
    private final String _name;
    private final String _hostel_no;
    private final String _floor_no;
    private final String _room_no;
    private final String _room_type;
    private final String _bed_type;
    private final String _date;

    public String getReg_no() {
        return _reg_no;
    }

    public String getName() {
        return _name;
    }

    public String getHostel_no() {
        return _hostel_no;
    }

    public String getFloor_no() {
        return _floor_no;
    }

    public String getRoom_no() {
        return _room_no;
    }

    public String getRoom_type() {
        return _room_type;
    }

    public String getBed_type() {
        return _bed_type;
    }

    public String getDate() {
        return _date;
    }

    public Hostel(String _reg_no, String _name, String _hostel_no,
            String _floor_no, String _room_no, String _room_type,
            String _bed_type, String _date) {
        this._reg_no = _reg_no;
        this._name = _name;
        this._hostel_no = _hostel_no;
        this._floor_no = _floor_no;
        this._room_no = _room_no;
        this._room_type = _room_type;
        this._bed_type = _bed_type;
        this._date = _date;
    }

}
