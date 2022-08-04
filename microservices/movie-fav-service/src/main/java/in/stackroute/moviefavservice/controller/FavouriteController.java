package in.stackroute.moviefavservice.controller;

import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.moviefavservice.domain.Favourite;
import in.stackroute.moviefavservice.dto.FavouriteDto;
import in.stackroute.moviefavservice.dto.IdentityResponse;
import in.stackroute.moviefavservice.service.FavouriteService;
import in.stackroute.moviefavservice.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/favs")
@Slf4j
public class FavouriteController {

    private FavouriteService favouriteService;
    private UserService userService;
    private ModelMapper modelMapper;

    public FavouriteController(FavouriteService favouriteService, UserService userService, ModelMapper modelMapper) {
        this.favouriteService = favouriteService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> addFavourite(@RequestBody FavouriteDto dto,
            @RequestHeader("Authorization") String token) {

        // Already teoken validation is implemented in the Filter
        // IdentityResponse response = userService.validateToken(token.substring(7));
        // log.debug("TOKEN VALIDATION RESPONSE: {}", response);
        // if (!response.isValid()) {
        // return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        // .body(Map.of("message", "Invalid token", "status", HttpStatus.UNAUTHORIZED));
        // }
        Favourite fav = modelMapper.map(dto, Favourite.class);
        Favourite savedFav = favouriteService.createFavourite(fav);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(savedFav, FavouriteDto.class));
    }
}
