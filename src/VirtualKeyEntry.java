
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class VirtualKey {
    List <String> files;

    VirtualKey(){
        this.files = new ArrayList <String>();
    }

    public void add(){
        System.out.println("Keep adding files and when done press '1'");
        String value;
    	do {
        Scanner sc = new Scanner(System.in);
        value = sc.nextLine();
        this.files.add(value);
        }while (!value.equals("1"));
    }
    public void del(){
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        if (files.contains(value) == true) {
        	this.files.remove(value);
        	}else {
        	System.out.println("File not found - 'FNF'");
        	}
    }    
    public int printSearch(){
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        return this.files.indexOf(value);
    }
    
    public void search() {
         if (this.searchBoolean()==true) {
    		 int index = this.printSearch();
        	 if(index != -1)
             System.out.println("The said file " + this.files.get(index) + " is present");
    	 }else {
    		 System.out.println("File not found - FNF");
    	 }
    }
    public boolean searchBoolean() {
    	Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
    	return this.files.contains(value);
    }

    public void fetch() {
		Collections.sort(this.files);
		showFiles();
	}

	public void descending() {
		Collections.sort(this.files, Collections.reverseOrder());
		this.showFiles();
	}

	public void showFiles() {
		Iterator itr =  this.files.iterator();
		System.out.println("\n");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

    
    public void fileManagement(){
    	System.out.println("Application name: Virtual Key");
        System.out.println("Developer's name: ABC");
    	int choice;
        do {
        
        System.out.println(" Select the option");
        System.out.println("1. Main menu");
        System.out.println("2. Add a file");

        if (this.files.size()>0){
            System.out.println("3. Search the file");
            System.out.println("4. Delete the file");
            System.out.println("5. Fetch in ascending order");
        }
        System.out.println("6. Exit");

        Scanner Scan = new Scanner(System.in);
        choice = Scan.nextInt();

        switch(choice){
            case 2: {
                this.add();
                break;
            }
            case 3: {
                this.search();
            	//System.out.println("The file is present");
                break;
            }
            case 4: {
                this.del();
                break;
            }
            case 5: {
                this.fetch();
                break;
            }
         }
        }while(choice != 6);
    }
}

public class VirtualKeyEntry{
    public static void main(String[] args){
        VirtualKey virtualkey = new VirtualKey();

        virtualkey.fileManagement();

    }
}