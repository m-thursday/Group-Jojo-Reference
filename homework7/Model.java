import java.awt.Point;
import java.util.ArrayList;

class Model{
		int image_x;
		int image_y;
		int dest_x;
		int dest_y;
		static int speed = 4;

		public ArrayList<Thing> things = new ArrayList<Thing>();

		Model(){
			this.image_x = 150;
			this.image_y = 290;
			this.dest_x = 150;
			this.dest_y = 290;
			
		}


		public void update(){
			if(this.image_x < this.dest_x)
				this.image_x += Math.min(speed, dest_x - image_x);
			else if(this.image_x > this.dest_x)
				this.image_x -= Math.max(speed, dest_x - image_x);
			if(this.image_y < this.dest_y)
				this.image_y += Math.min(speed, dest_y - image_y);
			else if(this.image_y > this.dest_y)
				this.image_y -= Math.max(speed, dest_y - image_y);
		}

   		public void reset(){
       		image_x = 200;
       		image_y = 200;
       		dest_x = image_x;
       		dest_y = image_y;
    	}

		public void setDestination(int x, int y){
			this.dest_x = x;
			this.dest_y = y;
		}

		public void addThing(int x, int y, int kind){
			if(kind == 16){
				
				Jumper newJump = new Jumper(x,y,kind);
				things.add(newJump);
			}
			else{
			Thing newThing = new Thing(x,y,kind);
			things.add(newThing);
			}
		}

		public void removeThing(int ind){
			if (things.size() == 0){

			}
			else{
			things.remove(things.get(ind));
			}
		}

		public Json marshal(){
			Json map = Json.newObject();
			Json thingList = Json.newList();
			map.add("things", thingList);
			for (Thing t : things){
				Json myJson = Json.newObject();
				myJson.add("x", t.x);
				myJson.add("y", t.y);
				myJson.add("kind", t.kind);
				thingList.add(myJson);
			}
			return map;
		}

		public void unmarshal(Json mapData) {
            Json thingList = mapData.get("things");
        	if (thingList != null) {
           		this.things.clear();
           	 	for (int i = 0; i < thingList.size(); i++) {
                	Json myJson = thingList.get(i);
                	int x = (int) myJson.getLong("x");
                	int y = (int) myJson.getLong("y");
					int kind = (int) myJson.getLong("kind");
					this.addThing(x, y, kind);
            	}
        	}
    	}
			//load Json and unmarshal
		public void load(String fileName) {
			Json mapData = Json.load(fileName);
			unmarshal(mapData);
		}
			//marshal objects and save as Json
		public void save(String fileName) {
			Json mapData = marshal();
			mapData.save(fileName);
		}
	}	

	class Thing {

		public int x;
		public int y;
		public int kind;
		Model model = new Model();

	
		Thing(int x, int y, int kind)
		{
			this.x = x;
			this.y = y;
			this.kind = kind;
		}


		public Point getPosition(){

			return new Point(this.x, this.y);

		}
	}

	class Jumper extends Thing{

		Jumper(int x, int y, int kind){
			super(x, y,kind);
		}

		public Point getPosition(){
			return new Point(this.x, this.y - (int)Math.max(0., 50 * Math.sin(((double)View.t) / 5)));
		}

	}


