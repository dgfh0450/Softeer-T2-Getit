package com.softeer5.uniro_backend.node.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softeer5.uniro_backend.node.dto.GetBuildingResDTO;
import com.softeer5.uniro_backend.node.dto.SearchBuildingResDTO;
import com.softeer5.uniro_backend.node.service.NodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NodeController implements NodeApi {
	private final NodeService nodeService;

	@Override
	@GetMapping("/{univId}/nodes/buildings")
	public ResponseEntity<List<GetBuildingResDTO>> getBuildings(
		@PathVariable("univId") Long univId,
		@RequestParam(value = "level", required = false, defaultValue = "1") int level,
		@RequestParam(value = "left-up-lng") double leftUpLng,
		@RequestParam(value = "left-up-lat") double leftUpLat,
		@RequestParam(value = "right-down-lng") double rightDownLng,
		@RequestParam(value = "right-down-lat") double rightDownLat
	) {
		List<GetBuildingResDTO> buildingResDTOS = nodeService.getBuildings(univId, level, leftUpLng, leftUpLat,
			rightDownLng, rightDownLat);
		return ResponseEntity.ok().body(buildingResDTOS);
	}

	@Override
	@GetMapping("{univId}/nodes/buildings/search")
	public ResponseEntity<SearchBuildingResDTO> searchBuildings(
		@PathVariable("univId") Long univId,
		@RequestParam(value = "name", required = false) String name,
		@RequestParam(value = "cursor-id", required = false) Long cursorId,
		@RequestParam(value = "page-size", required = false, defaultValue = "6") Integer pageSize
	) {
		SearchBuildingResDTO searchBuildingResDTO = nodeService.searchBuildings(univId, name, cursorId, pageSize);
		return ResponseEntity.ok().body(searchBuildingResDTO);
	}

	@Override
	@GetMapping("{univId}/nodes/buildings/{nodeId}")
	public ResponseEntity<GetBuildingResDTO> getBuilding(
		@PathVariable("univId") Long univId,
		@PathVariable("nodeId") Long nodeId) {

		GetBuildingResDTO buildingResDTO = nodeService.getBuilding(nodeId);
		return ResponseEntity.ok().body(buildingResDTO);
	}

}
