def call(String filePath, Closure closure) {
    def request = libraryResource 'globalconfig.yml'
    println "$request"
    def map =  readYaml text: request
    println map
    
    def var2 = findFiles (glob: filePath)
    println var2.length
    
    def var3 = findFiles (glob: "roshmi.txt")
    println var3.length
    
    
    //def var = new File(".").getAbsolutePath()
    //def access_status = new File(var + "/" + filePath).exists()
    
    //println var
    //println access_status
    
   // if (access_status){
        def map1 = readYaml file: filePath
        println map1
        map.putAll(map1)
    //}

    MavenBuilder builder = new MavenBuilder(map_var: map)
    closure.delegate = builder
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    closure()
}

