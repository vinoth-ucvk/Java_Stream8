import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Toll{
    String vehicleId;
    String tollId;
    float time;
    String type;

    public Toll(String vehicleId, String tollId, float time, String type) {
        this.vehicleId = vehicleId;
        this.tollId = tollId;
        this.time = time;
        this.type = type;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getTollId() {
        return tollId;
    }

    public float getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Toll{" +
                "vehicleId='" + vehicleId + '\'' +
                ", tollId='" + tollId + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                '}';
    }
}

public class Example {
    public static void main(String[] args) {
        Toll t1 = new Toll("TN12","01", 9.15F,"IN");
        Toll t2 = new Toll("TN12","01", 10.15F,"OUT");
        Toll t3 = new Toll("TN12","01", 11.15F,"IN");
        Toll t5 = new Toll("TN15","01", 10.15F,"IN");
        Toll t4 = new Toll("TN12","01", 12.15F,"OUT");

        List<Toll> listEvent = Arrays.asList(t1,t2,t3,t4,t5);
        Map<String, List<Toll>> mapbyVehicle = listEvent.stream().
                collect(Collectors.groupingBy(Toll::getVehicleId));

        for(String key : mapbyVehicle.keySet()){
            List<Toll> vehicle = mapbyVehicle.get(key).stream()
                    .sorted(Comparator.comparing(Toll::getTime)).toList();

            for(Toll t : vehicle){
                System.out.println(t);
            }
        }



    }
}
