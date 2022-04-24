class UndergroundSystem {
    Map<Integer,Record>arrival;//{id,record}
    Map<String,double[]>total;//{to&fromstation,for average}
    class Record{
        int id;
        String stationName;
        int time;
        Record(int id,String stationName,int time){
            this.id=id;
            this.stationName=stationName;
            this.time=time;
        }
    }
    public UndergroundSystem() {
        arrival=new HashMap<>();
        total=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        arrival.put(id,new Record(id,stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Record arrivalrec=arrival.get(id);
        String key=arrivalrec.stationName+"_"+stationName;
        double[]pair=total.getOrDefault(key,new double[2]);
        int time=t-arrivalrec.time;
        pair[0]+=time;
        pair[1]++;
        total.put(key,pair);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key=startStation+"_"+endStation;
        double[]pair=total.get(key);
        return pair[0]/pair[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */