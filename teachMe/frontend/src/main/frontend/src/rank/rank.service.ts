/**
 * Created by E-M on 7/2/2017.
 */
import {Injectable} from "@angular/core";
import {Rank} from "./rank";
import {User} from "../login/user";

/**
 * Created by E-M on 4/27/2017.
 */



@Injectable()
export class RankService {


  ranks: Rank[];

  getRank(id: number){

    console.log("id ",id);

    switch(id){
      case 1: return new Rank(1,"Little Toto", "toto.png");
      case 2: return new Rank(2,"Jiji Cat", "jiji.png");
      case 3: return new Rank(3,"Little Sen", "chihiro.png");
      case 4: return new Rank(4,"Kiki Witch", "kiki.png");
      case 5: return new Rank(5,"Monoke Royalty", "princessmono.png");
      case 6: return new Rank(5,"Monoke Royalty", "princessmono.png");
      case 7: return new Rank(5,"Monoke Royalty", "princessmono.png");
      case 8: return new Rank(5,"Monoke Royalty", "princessmono.png");
      case 9: return new Rank(5,"Monoke Royalty", "princessmono.png");
      case 10: return new Rank(5,"Monoke Royalty", "princessmono.png");
    }

  }

  setRank(user: User): User {
    var XP = user.xp;
    var lvl_ratio = 1/4;

    console.log(user.xp);

    if(user.xp == 0){
      user.rank = this.getRank(1);
    } else {
      var id = (Math.round(lvl_ratio*Math.sqrt(XP)));
      console.log("XP: "+XP+" lvl: "+id);

      user.rank = this.getRank(id);
    }
    return user;
  }


}
