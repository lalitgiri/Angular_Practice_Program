import { TestBed, inject } from '@angular/core/testing';

import { TokenDecoderService } from './token-decoder.service';

describe('TokenDecoderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TokenDecoderService]
    });
  });

  it('should be created', inject([TokenDecoderService], (service: TokenDecoderService) => {
    expect(service).toBeTruthy();
  }));
});
