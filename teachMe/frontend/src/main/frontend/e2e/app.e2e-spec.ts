import { AngClientProjPage } from './app.po';

describe('ang-client-proj App', () => {
  let page: AngClientProjPage;

  beforeEach(() => {
    page = new AngClientProjPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
