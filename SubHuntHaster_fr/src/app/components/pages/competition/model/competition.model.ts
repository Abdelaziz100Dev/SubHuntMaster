

export class CompetitionModel {

  constructor(public id: number|null,
              public code: string,
              public startTime: Date,
              public status: string,
              public endTime: Date) {
  }

}
