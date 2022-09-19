class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            String root = split[0];
            for (int i = 1; i < split.length; i++) {
                String[] file = split[i].split("\\(");
                String fileName = file[0];
                String fileContent = file[1].substring(0, file[1].length() - 1);
                if (map.containsKey(fileContent)) {
                    map.get(fileContent).add(root + "/" + fileName);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(root + "/" + fileName);
                    map.put(fileContent, list);
                }
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }
        return result;       
    }
}