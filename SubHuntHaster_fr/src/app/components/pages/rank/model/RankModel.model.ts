
// "rank": 1,
//   "score": 0,
//   "competition":
// {"id":37 },
// "member": {"id":8}
import {CompetitionModel} from "../../competition/model/competition.model";
import {Member} from "../../competition/model/Member";

 export interface RankModel {
  rank: number;
  score: number;
  competition: {id: number|undefined};
  member: {id: number}
}
