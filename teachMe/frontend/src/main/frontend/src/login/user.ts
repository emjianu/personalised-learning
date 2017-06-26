import {Rank} from "./rank";
/**
 * Created by E-M on 4/27/2017.
 */


export class User {

  id: number;
  username: string;
  password: string;
  email: string;
  xp: number;
  level: number;
  rank: Rank;

  xpTilLvl: number;
  sessionXp: number;


}
