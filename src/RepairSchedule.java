import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        schedule = new ArrayList<CarRepair>();
        numberOfMechanics = n;
    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        for(int i = 0; i < schedule.size(); i++){
            int mNum = schedule.get(i).getMechanicNum();
            int bNum = schedule.get(i).getBayNum();
            if(mNum == m || bNum == b){
                return false;
            }
        }
        schedule.add(new CarRepair(m,b));
        return true;
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> available = new ArrayList<Integer>();
        for(int i = 0; i < numberOfMechanics; i++){
            available.add(i);

        }
        for(int i = 0; i < schedule.size(); i++){
            available.remove(schedule.get(i).getMechanicNum());
        }

        return available;
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}