package ink.divine.waypoints;

public class Waypoint {
    public String name;
    public double x;
    public double y;
    public double z;
    public int r;
    public int g;
    public int b;

    public Waypoint(final String name, final double x, final double y, final double z, final int r, final int g, final int b) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.g = g;
        this.b = b;
    }


    public static Waypoint[] parseWaypoints(String JSON) {
        /* example of many soopy waypoints:

[{"x":630,"y":39,"z":646,"r":0,"g":1,"b":0,"options":{"name":"1"}},{"x":629,"y":35,"z":657,"r":0,"g":1,"b":0,"options":{"name":"2"}},{"x":624,"y":33,"z":669,"r":0,"g":1,"b":0,"options":{"name":"3"}},{"x":629,"y":47,"z":679,"r":0,"g":1,"b":0,"options":{"name":"4"}},{"x":631,"y":53,"z":690,"r":0,"g":1,"b":0,"options":{"name":"5"}},{"x":642,"y":52,"z":679,"r":0,"g":1,"b":0,"options":{"name":"6"}},{"x":657,"y":42,"z":670,"r":0,"g":1,"b":0,"options":{"name":"7"}},{"x":666,"y":31,"z":671,"r":0,"g":1,"b":0,"options":{"name":"8"}},{"x":670,"y":35,"z":681,"r":0,"g":1,"b":0,"options":{"name":"9"}},{"x":678,"y":41,"z":681,"r":0,"g":1,"b":0,"options":{"name":"10"}},{"x":679,"y":34,"z":698,"r":0,"g":1,"b":0,"options":{"name":"11"}},{"x":686,"y":33,"z":706,"r":0,"g":1,"b":0,"options":{"name":"12"}},{"x":667,"y":32,"z":706,"r":0,"g":1,"b":0,"options":{"name":"13"}},{"x":637,"y":35,"z":690,"r":0,"g":1,"b":0,"options":{"name":"14"}},{"x":633,"y":41,"z":705,"r":0,"g":1,"b":0,"options":{"name":"15"}},{"x":632,"y":58,"z":713,"r":0,"g":1,"b":0,"options":{"name":"16"}},{"x":606,"y":57,"z":709,"r":0,"g":1,"b":0,"options":{"name":"17"}},{"x":609,"y":50,"z":691,"r":0,"g":1,"b":0,"options":{"name":"18"}},{"x":607,"y":56,"z":674,"r":0,"g":1,"b":0,"options":{"name":"19"}},{"x":618,"y":58,"z":659,"r":0,"g":1,"b":0,"options":{"name":"20"}},{"x":597,"y":51,"z":659,"r":0,"g":1,"b":0,"options":{"name":"21"}},{"x":580,"y":60,"z":653,"r":0,"g":1,"b":0,"options":{"name":"22"}},{"x":575,"y":61,"z":663,"r":0,"g":1,"b":0,"options":{"name":"23"}},{"x":573,"y":47,"z":667,"r":0,"g":1,"b":0,"options":{"name":"24"}},{"x":578,"y":49,"z":684,"r":0,"g":1,"b":0,"options":{"name":"25"}},{"x":577,"y":63,"z":693,"r":0,"g":1,"b":0,"options":{"name":"26"}},{"x":580,"y":43,"z":700,"r":0,"g":1,"b":0,"options":{"name":"27"}},{"x":582,"y":46,"z":709,"r":0,"g":1,"b":0,"options":{"name":"28"}},{"x":572,"y":52,"z":711,"r":0,"g":1,"b":0,"options":{"name":"29"}},{"x":589,"y":35,"z":682,"r":0,"g":1,"b":0,"options":{"name":"30"}},{"x":603,"y":34,"z":669,"r":0,"g":1,"b":0,"options":{"name":"31"}},{"x":571,"y":43,"z":667,"r":0,"g":1,"b":0,"options":{"name":"32"}},{"x":587,"y":45,"z":625,"r":0,"g":1,"b":0,"options":{"name":"33"}},{"x":596,"y":46,"z":617,"r":0,"g":1,"b":0,"options":{"name":"34"}},{"x":601,"y":36,"z":609,"r":0,"g":1,"b":0,"options":{"name":"35"}},{"x":586,"y":47,"z":595,"r":0,"g":1,"b":0,"options":{"name":"36"}},{"x":582,"y":42,"z":586,"r":0,"g":1,"b":0,"options":{"name":"37"}},{"x":605,"y":63,"z":586,"r":0,"g":1,"b":0,"options":{"name":"38"}},{"x":599,"y":63,"z":612,"r":0,"g":1,"b":0,"options":{"name":"39"}},{"x":608,"y":55,"z":630,"r":0,"g":1,"b":0,"options":{"name":"40"}},{"x":622,"y":47,"z":629,"r":0,"g":1,"b":0,"options":{"name":"41"}}]

 */
        String waypoints = JSON.substring(1, JSON.length() - 1);
        String[] waypointStrings = waypoints.split("},");
        Waypoint[] waypointArray = new Waypoint[waypointStrings.length];
        for (int i = 0; i < waypointStrings.length; i++) {
            String waypointString = waypointStrings[i];
            String[] waypointStringSplit = waypointString.split(",");
            String name = waypointStringSplit[6].split(":")[1].substring(1, waypointStringSplit[6].split(":")[1].length() - 1);
            double x = Double.parseDouble(waypointStringSplit[0].split(":")[1]);
            double y = Double.parseDouble(waypointStringSplit[1].split(":")[1]);
            double z = Double.parseDouble(waypointStringSplit[2].split(":")[1]);
            int r = Integer.parseInt(waypointStringSplit[3].split(":")[1]);
            int g = Integer.parseInt(waypointStringSplit[4].split(":")[1]);
            int b = Integer.parseInt(waypointStringSplit[5].split(":")[1]);
            waypointArray[i] = new Waypoint(name, x, y, z, r, g, b);
        }

        return waypointArray;

    }
}