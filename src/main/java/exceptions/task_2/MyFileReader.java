package exceptions.task_2;

import java.io.File;

class MyFileReader implements AutoCloseable{
    private File file;

    public MyFileReader(File file){
        this.file = file;
    }

    public void readFile() throws Exception {
        if(file.exists()) {
            System.out.println("File exists. Starting to read file...");
        }else {
            throw new Exception();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed MyFileReader.");
    }

}
